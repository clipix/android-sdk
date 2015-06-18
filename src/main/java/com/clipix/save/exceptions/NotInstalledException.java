package com.clipix.save.exceptions;

public class NotInstalledException extends RuntimeException {
  public static final String MESSAGE = "Clipix is not installed!";

  public NotInstalledException() {
    super("Clipix is not installed!");
  }
}
