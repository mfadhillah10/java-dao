package com.sti.bootcamp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sti.bootcamp.dao.interfc.CustomerDao;


@RestController
@RequestMapping("/dummy")
public class ControllerDummy {
	
	@Autowired
	private CustomerDao customerDao;
	
	// create
//		@PostMapping("/customer")
//		public PostCustomer create(@RequestBody PostCustomer customer) {
//			customer.getCust_number();
//			customer.getFirst_name();
//			return customer;
//		}
	
	//get by id
	@GetMapping("/customer")
	public String hello(@RequestParam(value = "custnumber", defaultValue = "") String cust_number) {
		try {
			PostCustomer customer = customerDao.getById(Integer.valueOf(cust_number));
			if (customer == null) {
				return "Data not found";
			}
			else {
				return "Hello "+customer.getFirstname()+ " "+customer.getLastname();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return "Wrong input format";
		} catch (Exception e) {
			return String.format("There is a problem on system: %s", e.getMessage());
		}
	}
	
//	// update
//	@PutMapping("/customer")
//	public String custUpdate(@RequestBody PostCustomer customer) {
//		return customer.getFirst_name();
//	}
	
	// delete
//	@DeleteMapping("/customer/{id}")
//	public PostCustomer custDelete(@PathVariable ("id") int id) {
//		PostCustomer cust = new PostCustomer();
//		cust.setCust_number(id);
//		return cust;
//	}
	
	// getList
//	@GetMapping("/customers")
//	public ArrayList<PostCustomer> getAll() {
//		PostCustomer cust = new PostCustomer();
//		ArrayList<PostCustomer> list = new ArrayList<PostCustomer>();
//		return list;
//	}
	
//	@GetMapping("/customerss")
//	public List<PostCustomer> getListAll() {
//		PostCustomer cust = new PostCustomer();
//		cust.getCust_number();
//		cust.getFirst_name();
//		ArrayList<PostCustomer> list = new ArrayList<PostCustomer>();
//		list.add(cust);
//		return list;
//	}
}
