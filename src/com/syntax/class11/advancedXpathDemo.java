package com.syntax.class11;

public class advancedXpathDemo {

	public static void main(String[] args) {

		/*
		 * Advanced xpath is based on parent and child, sibling relationships
		 * 
		 * example: identifying the element by it's following sibling
		 * 		//label[@id = 'nave-search-label']/following-sibling::input ----> to go next
		 * 		//input[@id = 'calFromDate']/following-sibling::img
		 * 
		 * example: identyifyng the element by its preceding sibling
		 * 		//span[text() = '& Orders']/preceding-sibling::span --> to go back
		 * 
		 * example: identifying the element by its parent
		 * 		//span[text() = '& Orders']/parent::a
		 * 
		 *	example: identifying the element by its acestor
		 		//input[@id = 'calFromDate']/ancestor::from
		 		 
		 		 
		 example: identifying the 
		 		 
		 		 * <li> --> list
		 		 * <ol> --> ordered list
		 		 * <ul> --> unordered list
		 		 * <p> -->paragraph
		 		 * <div> --> division
		 		 * <img> --> image
		 		 * <h>--> header
		 * 
		 */

	}

}
