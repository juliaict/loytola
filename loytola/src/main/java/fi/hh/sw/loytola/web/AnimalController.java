package fi.hh.sw.loytola.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.hh.sw.loytola.domain.Animal;
import fi.hh.sw.loytola.domain.AnimalKindRepository;
import fi.hh.sw.loytola.domain.AnimalRepository;
import fi.hh.sw.loytola.domain.BreedRepository;
import fi.hh.sw.loytola.domain.DepartureCauseRepository;
import fi.hh.sw.loytola.domain.Room;
import fi.hh.sw.loytola.domain.RoomKindRepository;
import fi.hh.sw.loytola.domain.RoomRepository;
import fi.hh.sw.loytola.domain.SexRepository;

@Controller
public class AnimalController {
	
	@Autowired
	private RoomRepository rrepository; 
	
	@Autowired
	private RoomKindRepository rkrepository;
	
	@Autowired
	private AnimalRepository arepository;
	
	@Autowired
	private BreedRepository brepository;
	
	@Autowired
	private SexRepository srepository;
	
	@Autowired
	private AnimalKindRepository akrepository;
	
	@Autowired
	private DepartureCauseRepository drepository;
	
		
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getNewAnimalForm(Model model) {
				return "index";//linkki index.html
	}
	//login
			@RequestMapping(value="/login")
		    public String login() {	
		        return "login";
		    }
	@RequestMapping(value="/roomlist")
    public String roomList(Model model) {	
        model.addAttribute("rooms", rrepository.findAll());
        return "roomlist";//linkki roomlist.html
    }
	@RequestMapping(value = "/add")
    public String addRoom(Model model){
    	model.addAttribute("room", new Room());
    	model.addAttribute("roomKinds", rkrepository.findAll());
        return "addroom";//linkki addroom.html
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Room room){
        rrepository.save(room);
        return "redirect:roomlist";
    }
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteRoom(@PathVariable("id") Long roomId, Model model) {
    	rrepository.deleteById(roomId);
        return "redirect:../roomlist";
    }
	
	@RequestMapping(value = "/roomanimals/{id}", method = RequestMethod.GET)
    public String roomAnimals(@PathVariable("id") Long roomId, Model model) {
    	model.addAttribute("room", rrepository.findById(roomId).get());
    	Room room=this.rrepository.findById(roomId).get();
    	model.addAttribute("animals", room.getAnimals());
    	return "roomanimallist";
    }
	
	@RequestMapping(value="/animallist")
    public String animalList(Model model) {	
        model.addAttribute("animals", arepository.findAll());
        return "animallist";//linkki roomlist.html
    }
	
	@InitBinder("animal")
    public void customizeBinding (WebDataBinder binder) {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "foundDate",
                                    new CustomDateEditor(dateFormatter, true));
        binder.registerCustomEditor(Date.class, "departureDate",
                new CustomDateEditor(dateFormatter, true));
    }
	
	@RequestMapping(value = "/addanimal")
    public String addAnimal(Model model){
    	model.addAttribute("animal", new Animal());
    	model.addAttribute("animalKinds", akrepository.findAll());
    	model.addAttribute("breeds", brepository.findAll());
    	model.addAttribute("sexs", srepository.findAll());
    	int fr=0;
    	model.addAttribute("rooms", rrepository.findByFreeGreaterThan(fr));
    	model.addAttribute("departureCauses", drepository.findAll());
        return "addanimal";//linkki addanimal.html
    }
	
	@RequestMapping(value = "/saveanimal", method = RequestMethod.POST)
    public String saveAnimal(Animal animal){
        arepository.save(animal);
        return "redirect:animallist";
    }
	
	@RequestMapping(value = "/deleteanimal/{id}", method = RequestMethod.GET)
    public String deleteAnimal(@PathVariable("id") Long animalId, Model model) {
    	arepository.deleteById(animalId);
        return "redirect:../animallist";
    }
	
	@RequestMapping(value = "/editanimal/{id}", method = RequestMethod.GET)
    public String editAnimal(@PathVariable("id") Long animalId, Model model) {
    	model.addAttribute("animal", arepository.findById(animalId));
    	Animal animal =this.arepository.findById(animalId).get();
    	model.addAttribute("kind",animal.getAnimalKind().getAnimalKindId());
    	model.addAttribute("animalKinds", akrepository.findAll());
    	model.addAttribute("br",animal.getBreed().getBreedId());
    	model.addAttribute("breeds", brepository.findAll());
    	model.addAttribute("s",animal.getSex().getSexId());
    	model.addAttribute("sexs", srepository.findAll());
    	model.addAttribute("r",animal.getRoom().getRoomId());
    	int fr=0;
    	model.addAttribute("rooms", rrepository.findByFreeGreaterThan(fr));
    	model.addAttribute("departureCauses", drepository.findAll());
    	return "editanimal";
    }
	
	
	
	@RequestMapping(value="/rooms", method = RequestMethod.GET)
    public @ResponseBody List<Room> roomListRest() {	
        return (List<Room>) rrepository.findAll(); //Restful kaikki eläinpaikat
    }    
	
 
    @RequestMapping(value="/room/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Room> findRoomRest(@PathVariable("id") Long roomId) {	
    	return rrepository.findById(roomId); // Restful löytää eläinpaikka id-tunnuksella
    }    

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editRoom(@PathVariable("id") Long roomId, Model model) {
    	model.addAttribute("room", rrepository.findById(roomId));
    	Room room=this.rrepository.findById(roomId).get();
    	model.addAttribute("kind", room.getRoomKind().getRoomKindId());
    	model.addAttribute("roomKinds", rkrepository.findAll());
    	return "editroom";
    }
	
	
}


