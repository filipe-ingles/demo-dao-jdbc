package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
		
		System.out.println("==== TEST 1: department findById ====");
		Department dep = departmentDao.findById(1);
		System.out.println(dep);
		
		System.out.println("\n==== TEST 2: department findAll ====");
		List<Department> list = departmentDao.findAll();
		list.forEach(System.out::println);
		
		System.out.println("\n==== TEST 3: department insert ====");
		Department newDep = new Department(null, "Photos");
		departmentDao.insert(newDep);
		System.out.println("Inserted! new Id is = " + newDep.getId());
		
		System.out.println("\n==== TEST 4: department update ====");
		dep = departmentDao.findById(8);
		dep.setName("Photos");
		departmentDao.update(dep);
		System.out.println("Updated completed! New department name = " + dep.getName());
		
		System.out.println("\n==== TEST 5: department delete ====");
		System.out.print("Enter id for delete: ");
		int id = sc.nextInt();
		departmentDao.deleteById(id);
		System.out.println("Delete completed");
		
		sc.close();

	}

}
