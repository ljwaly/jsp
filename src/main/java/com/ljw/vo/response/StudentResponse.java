package com.ljw.vo.response;

import java.util.List;

import com.ljw.domain.people.Student;

public class StudentResponse extends BaseResponse{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6273032808872159903L;

	private List<Student> studentList;

	public List<Student> getStudentList() {
		return studentList;
	}

	public void setStudentList(List<Student> studentList) {
		this.studentList = studentList;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((studentList == null) ? 0 : studentList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentResponse other = (StudentResponse) obj;
		if (studentList == null) {
			if (other.studentList != null)
				return false;
		} else if (!studentList.equals(other.studentList))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "StudentResponse [studentList=" + studentList + "]";
	}

	
	
	
}
