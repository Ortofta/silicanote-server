package org.silicanote.webapp.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.ws.rs.PathParam;
import org.silicanote.engine.service.NoteService;
import org.silicanote.model.Note;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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
    
    @Resource
    private NoteService service;
    
    @RequestMapping(value="/getnotes", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<Note> getNotes() {
        return service.getNotes();
    }
    
    @RequestMapping(value="/getnote/{id}", method = RequestMethod.GET, produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Note getNotes(@PathParam(value = "id") long id) {
        return service.getNote(id);
    }
    
    @RequestMapping(value="/addnote", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public void createNote(@RequestBody Note note){
        service.addNote(note);
    }
   
    @RequestMapping(value = "/deletenote/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public void deleteNote(@PathParam(value = "id") long id) {
        service.deleteNote(id);
    }

    public void setService(NoteService service) {
        this.service = service;
    }
}
