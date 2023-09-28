package com.seduc.appcc.bodies;
import com.seduc.appcc.entities.Report;

public class ReportBody{
		Report report;
		Long schoolId;
		
		public ReportBody() {
			
		}
		
		
		public ReportBody(Report report, Long schoolId) {
			super();
			this.report = report;
			this.schoolId = schoolId;
		}


		public Report getReport() {
			return report;
		}
		public void setReport(Report report) {
			this.report = report;
		}
		public Long getSchoolId() {
			return schoolId;
		}
		public void setSchoolId(Long schoolId) {
			this.schoolId = schoolId;
		}
		
		
		
	}