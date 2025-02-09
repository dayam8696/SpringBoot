package com.edigest.dayamJournalApp.controller;

import com.edigest.dayamJournalApp.entry.JournalEntry;
import com.edigest.dayamJournalApp.services.JounrnalEnrtyService;
import org.bson.types.ObjectId;
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

        @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
       return jounrnalEnrtyService.findById(myId).orElse(null) ;
    }
    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntries(@PathVariable ObjectId myId) {
        jounrnalEnrtyService.deleteById(myId);
        return true;
    }

    @PutMapping("/id/{id}")
    public JournalEntry updateJournalById(@PathVariable ObjectId id, @RequestBody JournalEntry newEntry) {
       JournalEntry old = jounrnalEnrtyService.findById(id).orElse(null);
       if (old!=null){
           old.setTitle(newEntry.getTitle()!=null&& !newEntry.getTitle().equals("")?newEntry.getTitle():old.getTitle());
           old.setContent(newEntry.getContent()!=null&& !newEntry.equals(" ")?newEntry.getContent():old.getContent());
       }


        jounrnalEnrtyService.saveEntry(old);
        return old;
    }

}
