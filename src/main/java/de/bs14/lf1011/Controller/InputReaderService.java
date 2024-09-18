package de.bs14.lf1011.Controller;

import java.util.Scanner;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InputReaderService {
  public String readInput() {
    Scanner scanner = new Scanner(System.in);
    while (true) {
      if (scanner.hasNextLine()) {
        String output = scanner.nextLine();
        return output;

      }
    }
  }
}
