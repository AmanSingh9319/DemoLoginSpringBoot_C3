/*
 *Author Name: Aman Singh
 *Date:29-11-2022
 *Created With: Intellij IDEA Community Edition
 */
package com.NIIT.DemoLoginSpringBoot_C3.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "login failed")
public class Usernotfoundexception extends Exception {
}
