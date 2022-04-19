package com.springrest.springrest.controller;



import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



import  com.springrest.springrest.services.CourseService;
import com.springrest.springrest.entities.Course;



@RestController
public class MyController {


@Autowired
private CourseService CourseSerivice;

@GetMapping("/home")
public String home() {
return "this is home page";
}

//get the courses( return list )
@GetMapping("/courses")
public List<Course> getCourses(){

return this.CourseSerivice.getCourses();
//COntroller request to other layer for courses
}
@GetMapping("/courses/{courseId}")
public Course getCourse(@PathVariable String courseId)
{
return this.CourseSerivice.getCourse(Long.parseLong(courseId));
}
@PostMapping("/courses")
public Course addCourse(@RequestBody Course course)
{
return this.CourseSerivice.addCourse(course);
}

@PutMapping("/courses")
public Course updateCourse(@RequestBody Course course) {
return this.CourseSerivice.updateCourse(course);
}
@DeleteMapping("/courses/{courseId}")
public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId){
try {
this.CourseSerivice.deleteCourse(Long.parseLong(courseId));
return new ResponseEntity<>(HttpStatus.OK);
}catch(Exception e) {
return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
}


}
}