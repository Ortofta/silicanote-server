package org.silicanote.webapp.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.silicanote.engine.service.NoteService;
import org.silicanote.model.db.DBNote;
import org.silicanote.model.web.WebNote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Markus Svensson
 */
@Controller
@RequestMapping("/services/notes")
public class NoteController {
    
    private static final Logger logger = LoggerFactory.getLogger(NoteController.class);
    
    @Resource
    private NoteService service;
    
    @RequestMapping(value="/getnotes", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<WebNote> getNotes(Principal principal) {
        List<DBNote> dbNotes = service.getNotes(principal.getName());
        ArrayList<WebNote> notes = new ArrayList<>();
        
        for(DBNote note : dbNotes) {
            notes.add(new WebNote(note.getId(), note.getHeading(), note.getBody()));
        }
        
        return notes;
    }
    
    @RequestMapping(value="/getnote/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public WebNote getNote(@PathVariable("id") String id, Principal principal) {
        logger.info("Getting note with name: " + id);

        DBNote note = service.getNote(id, principal.getName());
        return new WebNote(note.getId(), note.getHeading(), note.getBody());
    }
    
    @RequestMapping(value="/addnote", method = RequestMethod.POST, consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createNote(@RequestBody WebNote note, Principal principal){
        service.addNote(new DBNote(note.getId(), note.getHeading(), note.getBody()), principal.getName());
    }
   
    @RequestMapping(value = "/deletenote/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteNote(@PathVariable("id") String id, Principal principal) {
        service.deleteNote(id, principal.getName());
    }

    public void setService(NoteService service) {
        this.service = service;
    }
}
