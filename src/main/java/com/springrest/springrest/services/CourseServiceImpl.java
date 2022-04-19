package com.springrest.springrest.services;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;import org.springframework.stereotype.Service;
import com.springrest.springrest.entities.Course;
@Service
public class CourseServiceImpl implements CourseService {
List<Course>list;
public CourseServiceImpl() {
list = new ArrayList<>();
list.add(new Course(145,"java core","this course basic"));
} @Override
public List<Course> getCourses() {
// TODO Auto-generated method stub
return list;
}
@Override
public Course getCourse(long courseId) {
// TODO Auto-generated method stub
Course c=null;
for(Course course:list)
{
if(course.getId()==courseId)
{
c=course;
break;
}
}
return c;

}
@Override
public Course addCourse(Course course) {
// TODO Auto-generated method stub
list.add(course);
return course;
}

@Override
public Course updateCourse(Course course) {
list.forEach(e ->{
if(e.getId() == course.getId()) {
e.setTitle(course.getTitle());
e.setDescription(course.getDescription());
}
});
return course;
}

@Override
public void deleteCourse(long parseLong) {
list=this.list.stream().filter(e->e.getId()!=parseLong).collect(Collectors.toList());
}
}

