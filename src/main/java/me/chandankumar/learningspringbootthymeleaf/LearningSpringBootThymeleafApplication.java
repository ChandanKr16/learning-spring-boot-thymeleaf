package me.chandankumar.learningspringbootthymeleaf;

import me.chandankumar.learningspringbootthymeleaf.entities.Student;
import me.chandankumar.learningspringbootthymeleaf.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LearningSpringBootThymeleafApplication {

    @Autowired
    private StudentService studentService;

    public static void main(String[] args) {
        SpringApplication.run(LearningSpringBootThymeleafApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            studentService.add(new Student("Adolphe", "Dayton", "Programmer Analyst I", "adayton3@skyrock.com", "78.94.151.226"));
            studentService.add(new Student("Justin", "Carding", "Account Executive", "jcarding4@nydailystudentService.add(news.com", "222.10.176.249"));
            studentService.add(new Student("Arley", "Reolfi", "Physical Therapy Assistant", "areolfi5@marriott.com", "167.9.187.224"));
            studentService.add(new Student("Eugenius", "Osler", "Software Consultant", "eosler6@unicef.org", "237.97.203.160"));
            studentService.add(new Student("Tammy", "Tolchar", "Analog Circuit Design manager", "ttolchar7@wiley.com", "64.132.125.120"));
            studentService.add(new Student("Virgil", "Maddinon", "Professor", "vmaddinon8@blogspot.com", "95.186.238.111"));
            studentService.add(new Student("Olwen", "McEnteggart", "Web Developer III", "omcenteggart9@alibaba.com", "53.210.35.34"));
            studentService.add(new Student("Yvette", "Farloe", "Community Outreach Specialist", "yfarloea@ezinearticles.com", "95.252.47.19"));
            studentService.add(new Student("Brandtr", "Moverley", "Structural Engineer", "bmoverleyb@goo.gl", "44.216.87.117"));
            studentService.add(new Student("Ulrick", "Campling", "Payment Adjustment Coordinator", "ucamplingc@google.ca", "213.206.132.250"));
            studentService.add(new Student("Fredrick", "Moret", "Programmer II", "fmoretd@etsy.com", "246.144.11.158"));
            studentService.add(new Student("Selinda", "Colomb", "Food Chemist", "scolombe@google.ca", "47.180.251.175"));
            studentService.add(new Student("Ara", "Hammarberg", "Nurse Practicioner", "ahammarbergf@si.edu", "133.152.104.70"));
            studentService.add(new Student("Annamarie", "Gostridge", "Research Associate", "agostridgeg@sphinn.com", "133.171.219.186"));
            studentService.add(new Student("Gradey", "Pounds", "Quality Control Specialist", "gpoundsh@hugedomains.com", "131.65.234.76"));
            studentService.add(new Student("Pooh", "Hurche", "Mechanical Systems Engineer", "phurchei@tinyurl.com", "75.187.16.10"));
            studentService.add(new Student("Kiersten", "Shakle", "Marketing Manager", "kshaklej@irs.gov", "96.148.237.221"));
            studentService.add(new Student("Harley", "Safont", "Actuary", "hsafontk@usda.gov", "101.90.248.164"));
       };
    }

}
