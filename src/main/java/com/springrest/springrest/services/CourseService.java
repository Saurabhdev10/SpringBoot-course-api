package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {
	
	public List<Course> getCourses();

	public Course getCourseById(long courseId);

	public Course addCourse(Course course);
	
	public void deleteCourseById(long courseId);
	
	public Course updateCourseById(long courseId, Course updatedData);


	

}