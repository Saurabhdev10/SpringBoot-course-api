package com.springrest.springrest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import java.util.ArrayList;

import com.springrest.springrest.dao.CourseDao;
import com.springrest.springrest.entities.Course;

@Service
public class CourseServiceImpl implements CourseService {

	@Autowired
	private CourseDao courseDao;

//	List<Course> list;

	public CourseServiceImpl() {
//		list = new ArrayList<>();
//		list.add(new Course(123, "Psychology", "This is psychology course"));
//		list.add(new Course(146, "Java", "This is java book"));
	}

	@Override
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return courseDao.findAll();
	}

	@Override
	public Course getCourseById(long courseId) {
//		Course c = null;
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				c = course;
//				break;
//			}
//		}

		return courseDao.findById(courseId).orElse(null);
	}

	@Override
	public Course addCourse(Course course) {
//		list.add(course);
		courseDao.save(course);
		return course;

	}

	@Override
	public void deleteCourseById(long courseId) {
//		list.removeIf(course -> course.getId() == courseId);
		courseDao.deleteById(courseId);

	}

	@Override
	public Course updateCourseById(long courseId, Course updatedData) {
//		Course courseToUpdate = null;
//
//		for (Course course : list) {
//			if (course.getId() == courseId) {
//				courseToUpdate = course;
//
//				// Update only non-null fields
//				if (updatedData.getTitle() != null) {
//					course.setTitle(updatedData.getTitle());
//				}
//				if (updatedData.getDescription() != null) {
//					course.setDescription(updatedData.getDescription());
//				}
//				break;
//			}
//		}
		Course courseToUpdate = courseDao.findById(courseId).orElse(null);

		if (courseToUpdate != null) {
			if (updatedData.getTitle() != null) {
				courseToUpdate.setTitle(updatedData.getTitle());
			}
			if (updatedData.getDescription() != null) {
				courseToUpdate.setDescription(updatedData.getDescription());
			}
			return courseDao.save(courseToUpdate);
		}

		return null;

	}

}
