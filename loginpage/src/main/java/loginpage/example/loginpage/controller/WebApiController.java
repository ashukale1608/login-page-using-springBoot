package loginpage.example.loginpage.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import loginpage.example.loginpage.dov.WebApiRepo;
import loginpage.example.loginpage.model.WebApi;


@RestController
public class WebApiController {

    @Autowired
    WebApiRepo webApiRepo;

    @RequestMapping("/loginPage")
    public ModelAndView home() {
        // System.out.println("in get all data");
        ModelAndView mv = new ModelAndView("login");
        return mv;
    }

    @RequestMapping("/addDataByWeb")
    public ModelAndView addDataByWeb(WebApi webApi) {
        ModelAndView mv = null;
        if (webApi.getName().isEmpty() || webApi.getEmail().isEmpty() || webApi.getPassword().isEmpty()) {
            mv = new ModelAndView("WorngData");
        } else {
            webApiRepo.save(webApi);
            mv = new ModelAndView("home");
            mv.addObject("webApiList", webApi); // Use a proper attribute name
        }
        return mv;
    }

    @GetMapping("/getAllData")
    public String addData() {
        String webApiList = webApiRepo.findAll().toString();
        // System.out.println(webApiList);
        return webApiList;
    }

    @PostMapping("/addData")
    public ResponseEntity<Object> addData(@RequestBody WebApi webApi) {
        try {
            if (webApi.getName() != null && webApi.getEmail() != null && webApi.getPassword() != null) {
                WebApi toSaveWebApi = webApiRepo.save(webApi);
                if (toSaveWebApi != null) {
                    return new ResponseEntity<>(toSaveWebApi, HttpStatus.OK);
                } else {
                    return new ResponseEntity<>("not Saved", HttpStatus.NOT_FOUND);
                }
            } else {
                return new ResponseEntity<>("Data is not crect", HttpStatus.NOT_FOUND);
            }

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @GetMapping("/getDataById/{id}")
    public ResponseEntity<Object> getDataById(@PathVariable("id") int id) {
        Optional<WebApi> webApiById = webApiRepo.findById(id);
        if (webApiById.isPresent()) {
            return new ResponseEntity<>(webApiById, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getDataByName/{name}")
    public ResponseEntity<Object> getDataByName(@PathVariable("name") String name) {
        Optional<WebApi> webApiByName = webApiRepo.findByName(name);
        if (webApiByName.isPresent()) {
            return new ResponseEntity<>(webApiByName, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteDataById/{id}")
    public ResponseEntity<Object> deleteDataById(@PathVariable("id") int id) {
        Optional<WebApi> webApiToDelete = webApiRepo.findById(id);
        if (webApiToDelete.isPresent()) {
            webApiRepo.deleteById(id);
            return new ResponseEntity<>(webApiToDelete, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("not Found", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteAllData")
    public ResponseEntity<Object> deleteAllData() {
        webApiRepo.deleteAll();
        return new ResponseEntity<>("deleted successfully", HttpStatus.OK);
    }

    @PutMapping("/updateDataById/{id}")
    public ResponseEntity<Object> updateDataById(@PathVariable("id") int id, @RequestBody WebApi updateWebApi) {
        Optional<WebApi> toUpdateWebApi = webApiRepo.findById(id);
        if (toUpdateWebApi.isPresent()) {
            WebApi getUpdatedWebApi = toUpdateWebApi.get();
            // getUpdatedWebApi.setId(updateWebApi.getId());
            getUpdatedWebApi.setName(updateWebApi.getName());
            getUpdatedWebApi.setEmail(updateWebApi.getEmail());
            getUpdatedWebApi.setPassword(updateWebApi.getPassword());
            webApiRepo.save(getUpdatedWebApi);
            return new ResponseEntity<>(getUpdatedWebApi, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("hot found", HttpStatus.NOT_FOUND);
        }
    }

}



