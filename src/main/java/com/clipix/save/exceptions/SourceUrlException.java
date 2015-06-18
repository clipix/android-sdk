package com.clipix.save.exceptions;

public class SourceUrlException extends RuntimeException {
  public static final String MESSAGE = "url cannot be null! Did you call setUrl?";

  public SourceUrlException() {
    super("url cannot be null! Did you call setUrl?");
  }
}
