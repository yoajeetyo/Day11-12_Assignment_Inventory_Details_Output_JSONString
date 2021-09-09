package com.bridgelabz.InventoryDetails;

import java.io.File;
import java.io.IOException;
import java.util.jar.JarException;

import com.bridgelabz.model.InventoryDetailModel;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.json.JsonMapper;


public class InventoryDetails {

	public static void main(String[] args) throws JarException, JacksonException, IOException {

		String path = ".\\jsonFiles\\inventoryDetails.json";
		String path2 =  ".\\jsonFiles\\inventoryDetailsOutput.json";

		JsonMapper mapper = new JsonMapper();

		InventoryDetailModel model = mapper.readValue(new File(path), InventoryDetailModel.class);

		int total = 0;
		System.out.println("Rice : " + model.getRice().get(0).getName());
		System.out.println("Price per kg  : " + model.getRice().get(0).getPrice_per_kg());
		System.out.println("Weight : " + model.getRice().get(0).getWeight());
		total += model.getRice().get(0).getPrice_per_kg()*model.getRice().get(0).getWeight();
		System.out.println();
		
		System.out.println("wheats : " + model.getWheats().get(0).getName());
		System.out.println("Price per kg : " + model.getWheats().get(0).getPrice_per_kg());
		System.out.println("Weight : " + model.getWheats().get(0).getWeight());
		total += model.getWheats().get(0).getPrice_per_kg()*model.getWheats().get(0).getWeight();
		System.out.println();
		
		System.out.println("pulses : " + model.getPulses().get(0).getName());
		System.out.println("Price per kg : " + model.getPulses().get(0).getPrice_per_kg());
		System.out.println("Weight : " + model.getPulses().get(0).getWeight());
		total += model.getPulses().get(0).getPrice_per_kg()*model.getPulses().get(0).getWeight();
		System.out.println("\nTotal price : " + total);

		// code for writing all details into new file
		model.setTotal(total);
		mapper.writeValue(new File(path2), model);
		System.out.println("\nWrite into file is completed!!!");
	}
}