package com.edigest.dayamJournalApp.controller;

import com.edigest.dayamJournalApp.entry.JournalEntry;
import com.edigest.dayamJournalApp.services.JounrnalEnrtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JounrnalEnrtyService jounrnalEnrtyService;

    @GetMapping("/dym")
    public List<JournalEntry> getAll() {
        return jounrnalEnrtyService.getAll();
    }

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry) {
        myEntry.setDate(LocalDateTime.now());
        jounrnalEnrtyService.saveEntry(myEntry);
        return true;
    }

    //    @GetMapping("id/{myId}")
//    public JournalEntry getJournalEntryById(@PathVariable Long myId){
//        return null;
//    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntries(@PathVariable Long myId) {
        return null;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable Long id, @RequestBody JournalEntry myEntry) {
        return null;
    }

}
