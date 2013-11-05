/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.silicanote.webapp.controller;

import java.util.List;
import org.silicanote.model.Note;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Markus Svensson
 */
@Controller
@RequestMapping("/services/notes")
public class NoteController {
    
    @RequestMapping(value="/getnotes", method = RequestMethod.GET)
    @ResponseBody
    public List<Note> getNotes() {
        return null;
    }
    
    @RequestMapping(value="/getnote", method = RequestMethod.GET)
    @ResponseBody
    public Note getNotes(long id) {
        return null;
    }
    
    @RequestMapping(value="/addnote", method = RequestMethod.POST)
    public void createNote(Note note){
        
    }
   
    @RequestMapping(value = "/deletenote", method = RequestMethod.DELETE)
    public void deleteNote(long id) {
        
    }
}
