package com.jp.todo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.mail.Multipart;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.jp.todo.bo.EmployeeBo;
import com.jp.todo.bo.ProjectBo;
import com.jp.todo.service.EmployeeService;
import com.jp.todo.utils.PaginationClass;
import com.jp.todo.vo.EmployeeVo;
import com.jp.todo.vo.ProjectVo;

@Controller
public class EmployeeController {
	public static final String imageLocation = "/usr/local/mytodo/profileimages/";
	public static final String resumeLocation = "/usr/local/mytodo/resume/";
	@Autowired
	EmployeeService employeeService;

	@RequestMapping(value = "insert_employee", method = RequestMethod.GET)
	public String getCreateEmployee(Model model) {
		model.addAttribute("employeeBo", new EmployeeBo());
		return "employee_form";

	}

	@RequestMapping(value = { "insert_employee" }, method = RequestMethod.POST)
	public ModelAndView postCreateEmployee(@ModelAttribute("employeeBo") EmployeeBo employeeBo,
			@RequestParam("profileImage") MultipartFile profileImage, @RequestParam("resume") MultipartFile resume,
			HttpServletRequest request) throws IOException {
		String imageLocation = request.getServletContext().getInitParameter("image-upload");

		// String employee=request.getParameter("profileImage");

		ModelAndView model = new ModelAndView("redirect:/listEmployee");

		// image upload code
		String emp_Id = null;
		String profileImageName = null;
		String resumeFileName = null;
		long count = employeeService.retriveCount();
		if (0 < count) {
			long empId = count + 1;
			emp_Id = String.valueOf(empId);
		} else {
			long empId = 1;
			emp_Id = String.valueOf(empId);
		}

		String imageName = profileImage.getOriginalFilename();
		String[] words = imageName.split("\\.");
		int length = words.length;
		System.out.println(length);
		String format = words[length - 1];
		String image = emp_Id + "." + format;
		if (!imageName.isEmpty()) {
			profileImageName = imageLocation + emp_Id + "." + format;
			writeImageFile(profileImageName, profileImage);
		}

		// file upload code
		String resumeName = resume.getOriginalFilename();
		String fileFormat = ".pdf";
		String resumeFile = emp_Id + fileFormat;
		if (!resumeName.isEmpty()) {
			resumeFileName = resumeLocation + emp_Id + fileFormat;
			writeResumeFile(resumeFileName, resume);
		}

		int employeeId = employeeService.createEmployee(employeeBo, image, resumeFile);
		if (0 < employeeId) {
			model.addObject("errorMessage", "Employee Created Successfully!");
		} else {
			model.addObject("errorMessage", "Employee Creation Failed!");
		}
		return model;

	}

	public void writeImageFile(String profileImageName, MultipartFile profileImage) throws IOException {
		File file = new File(profileImageName);
		FileOutputStream fop = new FileOutputStream(file);
		fop.write(profileImage.getBytes());
	}

	public void writeResumeFile(String resumeFileName, MultipartFile resume) throws IOException {
		File file = new File(resumeFileName);
		FileOutputStream fop = new FileOutputStream(file);
		fop.write(resume.getBytes());
	}

	@RequestMapping(value = "listEmployee")
	public ModelAndView getListEmployee(HttpServletRequest request) {
		String paging = null;
		if (null != request.getParameter("page")) {
			paging = request.getParameter("page");
		}

		ModelAndView model = new ModelAndView("employee_list");
		if (null != request.getParameter("errorMessage")) {
			model.addObject("errorMessage", request.getParameter("errorMessage"));
		}
		List<EmployeeVo> listEmployee = employeeService.retriveEmployeeList();
		if (null != listEmployee && listEmployee.size() > 0) {
			model.addObject("listEmployee", listEmployee);
		} else {
			model.addObject("errorMessage", "No Record Found!");
		}

		employeePagination(paging, model);

		return model;

	}

	private void employeePagination(String paging, ModelAndView model) {
		EmployeeBo employeeBo = new EmployeeBo();
		long count = 0;
		long totalEmployeeCount = 0;
		long totalEmployeeRecordCount = 0;
		int page = 1;
		int maxRecord = 10;

		if (null != paging) {
			page = Integer.parseInt(paging);
		}
		count = employeeService.retriveCount();
		if (count != 0) {
			totalEmployeeRecordCount = count;
		}

		int startingRecordIndex = paginationValues(page, maxRecord);
		employeeBo.setStartingRecordIndex(startingRecordIndex);
		employeeBo.setMaxRecord(maxRecord);

		List<EmployeeBo> employeeList = new ArrayList<>();
		employeeList = employeeService.retriveEmployeeByPagination(employeeBo);
		if (null != employeeList && employeeList.size() > 0) {
			model.addObject("employeeList", employeeList);
			List<EmployeeBo> employeeLists = new ArrayList<>();
			totalEmployeeCount = totalEmployeeRecordCount;
			employeeLists.addAll(employeeList);
			model.addObject("employeeLists",
					PaginationClass.paginationLimitedRecords(page, maxRecord, totalEmployeeCount, employeeLists));
		}
	}

	private int paginationValues(int page, int maxRecord) {
		int pageRecords = 0;
		if (page == 1) {
			pageRecords = 0;
		} else {
			pageRecords = (page - 1) * maxRecord + 1;
			pageRecords = pageRecords - 1;
		}
		return pageRecords;

	}

	@RequestMapping(value = "editEmployee", method = RequestMethod.GET)
	public ModelAndView getEditEmployee(@RequestParam("employeeId") int employeeId) {
		ModelAndView model = new ModelAndView("employee_form");
		EmployeeVo employee = employeeService.retriveEmployeeBasedOnId(employeeId);
		if (null != employee) {
			model.addObject("employee", employee);
		} else {
			model.addObject("errorMessage", "Employee Edit Retrive Failed!");
		}
		return model;

	}

	@RequestMapping(value = "editEmployee", method = RequestMethod.POST)
	public ModelAndView postEditEmployee(@ModelAttribute("employeeBo") EmployeeBo employeeBo) {
		ModelAndView model = new ModelAndView();
		employeeService.updateEmployee(employeeBo);

		model.addObject("errorMessage", "Employee Updated Successfully!");
		model.setViewName("redirect:/listEmployee");
		return model;

	}

	@RequestMapping(value = "deleteEmployee", method = RequestMethod.GET)
	public ModelAndView getDeleteEmployee(@RequestParam("employeeId") int employeeId) {
		ModelAndView model = new ModelAndView();
		employeeService.deleteEmployee(employeeId);

		model.addObject("errorMessage", "Employee Deleted Successfully!");
		model.setViewName("redirect:/listEmployee");
		return model;

	}

	@RequestMapping(value = "employeeResumeDownload", method = RequestMethod.GET)
	public ModelAndView getResumeDownload(@RequestParam("employeeId") int employeeId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView();
		String fileLocation = "D:/usr/local/mytodo/resume/" + employeeId + ".pdf";
		String downloadPath = fileLocation;
		File file = new File(downloadPath);
		InputStream is = new FileInputStream(file);
		response.setContentType("application/pdf");

		response.setHeader("Content-Disposition", "attachment;filename=\"" + file.getName() + "\"");

		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		model.addObject("errorMessage", "Resume Download Successfully!");
		model.setViewName("redirect:/listEmployee");
		return model;

	}

	@RequestMapping(value = "employeeProfileImageDownload", method = RequestMethod.GET)
	public ModelAndView getImageDownload(@RequestParam("imageId") String imageId, HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		ModelAndView model = new ModelAndView();
		// String fileLocation="D:/usr/local/mytodo/profileimages/"+employeeId+".jpg";
		String fileLocation = "D:/usr/local/mytodo/profileimages/" + imageId;
		String downloadPath = fileLocation;
		File file = new File(downloadPath);
		InputStream is = new FileInputStream(file);
		response.setContentType("image/jpg");

		response.setHeader("Content-Disposition", "attachment;filename=\"" + file.getName() + "\"");

		OutputStream os = response.getOutputStream();
		byte[] buffer = new byte[1024];
		int len;
		while ((len = is.read(buffer)) != -1) {
			os.write(buffer, 0, len);
		}
		os.flush();
		os.close();
		is.close();
		model.addObject("errorMessage", "Profile Image Download Successfully!");
		model.setViewName("redirect:/listEmployee");
		return model;

	}

	@RequestMapping(value = "uploadEmployee", method = RequestMethod.GET)
	public String getUploadEmployee() {

		return "upload_employee";

	}

	@RequestMapping(value = "uploadEmployee", method = RequestMethod.POST)
	public String postUploadEmployee(@RequestParam("employeeFile") MultipartFile employeeFile) throws IOException {
		// Creates a workbook object from the uploaded excelfile
		XSSFWorkbook workbook = new XSSFWorkbook(employeeFile.getInputStream());
		// Creates a worksheet object representing the first sheet
		XSSFSheet worksheet = workbook.getSheetAt(0);
		// Reads the data in excel file until last row is encountered
		Iterator<Row> rowIterator = worksheet.iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next(); // Read Rows from Excel document
			if (row.getRowNum() >= 1) {
				EmployeeBo employeeBo = new EmployeeBo();
				Iterator<Cell> cellIterator = row.cellIterator();// Read every
				// column
				// for every
				// row that
				// is READ
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next(); // Fetch CELL
					if (cell.getColumnIndex() == 0) {
						if (null != cell.getStringCellValue()) {
							employeeBo.setFirstName(cell.getStringCellValue());
						}
					}

					if (cell.getColumnIndex() == 1) {
						if (null != cell.getStringCellValue()) {
							employeeBo.setLastName(cell.getStringCellValue());
						}
					}
					if (cell.getColumnIndex() == 2) {
						if (null != cell.getStringCellValue()) {
							employeeBo.setEmailId(cell.getStringCellValue());
						}
					}
					if (cell.getColumnIndex() == 3) {
						if (null != cell.getStringCellValue()) {
							employeeBo.setPassword(cell.getStringCellValue());
						}
					}

					if (cell.getColumnIndex() == 4) {
						if (0 < cell.getNumericCellValue()) {
							employeeBo.setMobileNumber((long) cell.getNumericCellValue());
						}
					}
					if (cell.getColumnIndex() == 5) {
						if (null != cell.getStringCellValue()) {
							employeeBo.setAddress(cell.getStringCellValue());
						}
					}
					if (cell.getColumnIndex() == 6) {
						if (null != cell.getStringCellValue()) {
							employeeBo.setCity(cell.getStringCellValue());
						}
					}
					if (cell.getColumnIndex() == 7) {
						if (null != cell.getStringCellValue()) {
							employeeBo.setState(cell.getStringCellValue());
						}
					}
					if (cell.getColumnIndex() == 8) {
						if (null != cell.getStringCellValue()) {
							employeeBo.setCountry(cell.getStringCellValue());
						}
					}

				}
				int id = employeeService.createEmployee(employeeBo, null, null);
				if (0 < id) {
					System.out.println("Employee Upload Success");
				}
			}

		}
		return "redirect:/listEmployee";
	}

}
