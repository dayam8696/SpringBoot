package com.edigest.dayamJournalApp.controller;

import com.edigest.dayamJournalApp.entry.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {
    private Map<Long ,JournalEntry> jounalEntires = new HashMap<>();
   @GetMapping
   public List<JournalEntry> getAll(){
return new ArrayList<>(jounalEntires.values());
    }
   @PostMapping
   public boolean createEntry(@RequestBody JournalEntry myEntry){
jounalEntires.put(myEntry.getId() ,myEntry);
return true;
   }
}
