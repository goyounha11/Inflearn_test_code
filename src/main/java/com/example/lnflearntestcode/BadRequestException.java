package com.example.lnflearntestcode;

public class BadRequestException extends RuntimeException {
  public BadRequestException() {
    super("Invalid input size");
  }
}
