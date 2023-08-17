
package com.flora.backend.loader;

import com.flora.backend.entities.CosmeticIngredient;

import com.flora.backend.entities.Rate;
import com.flora.backend.entities.Review;
import com.flora.backend.entities.properties.AcidesGras;
import com.flora.backend.entities.properties.Formule;
import com.flora.backend.entities.properties.Organoleptic;
import com.flora.backend.repository.CosmeticIngredientRepository;
import com.flora.backend.repository.ReviewRepository;
import com.flora.backend.repository.properties.AcideGrasRepository;
import com.flora.backend.repository.properties.FormuleRepository;
import com.flora.backend.repository.properties.OrganolepticRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Order(7)
@Slf4j
public class CosmeticIngredientLoader implements CommandLineRunner {
    @Autowired
    CosmeticIngredientRepository cosmeticIngredientRepository;
    @Autowired
    FormuleRepository formuleRepository;
    @Autowired
    AcideGrasRepository acideGrasRepository;

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    OrganolepticRepository organolepticRepository;
    @Override
    public void run(String... args) throws Exception {

        // Création d'une nouvelle instance de CosmeticIngredient
        CosmeticIngredient cosmetic1 = new CosmeticIngredient();
        cosmetic1.setName("Huile de pépins de figue de barbarie");
        cosmetic1.setDescription("L'huile de pépin de Figue de Barbarie est une huile très précieuse et très rare obtenue uniquement par pression à froid des graines d'Opuntia ficus indica.\nSa richesse exceptionnelle en Vitamine E (environ 1000 mg/kg) et en stérols (environ 10 g/kg) lui confère une aptitude hors du commun à protéger la peau contre les radicaux libres. Elle contient par ailleurs des quantités importantes d'acides gras essentiels, dont l'acide linoléique (oméga 6), et constitue donc un excellent adoucissant et réparateur cutané. Cette huile est donc un allié exceptionnel pour lutter contre le vieillissement cutané. Propriétés cosmétiques des acides gras insaturés : nourrissantes, protectrices, adoucissantes, assouplissantes, régénérantes, redonnent éclat et souplesse, préservent d'un vieillissement prématuré");
        cosmetic1.setCreatedAt(new Date());
        cosmetic1.setPayorigine("Maroc");
        cosmetic1.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic1.setOrganepresse("graines");
        cosmetic1.setNombotanique("Opuntiaficusindica");
        cosmetic1.setObtention("Première pression à froid");
        cosmetic1.setPrice(100);
        cosmetic1.setQuantity(2);
        int[] litrageArray = {100, 200, 300};
        cosmetic1.setLitrage(litrageArray);


// Organoleptic
        Organoleptic organoleptic = new Organoleptic();
        organoleptic.setAspect("liquide à 20°C");
        organoleptic.setCouleur("jaune à verte");
        organoleptic.setOdeur("gourmande, assez végétale");
        organoleptic.setToucher("sec");


// AcidesGras
        AcidesGras acidesGras = new AcidesGras();
        acidesGras.setAcidepunicique("65.40%");
        acidesGras.setAcideoleique("13.03%");
        acidesGras.setAcidepalmitique("11.88%");
// ... (ajoutez les autres acides gras)

// Formule
        Formule formule = new Formule();
        formule.setINCI("Punica Granatum Seed Oil");
        formule.setOxydation("sensible");
        formule.setInsaponifiable("tocophérols, stérols, alcool insaponifiable");
        formule.setSaponificationMoyenne("");
        formule.setStabiliteTemp("sensible");
        formule.setComedogenicite("1 (=peu comédogène)");

// Associer les entités entre elles
        cosmetic1.setOrganoleptic(organoleptic);
        cosmetic1.setAcidesGras(acidesGras);
        cosmetic1.setFormule(formule);


// Enregistrer l'instance de CosmeticIngredient
        cosmeticIngredientRepository.save(cosmetic1);



        CosmeticIngredient cosmetic2 = new CosmeticIngredient();
        cosmetic2.setName("Huile de pépins de figue de barbarie");
        cosmetic2.setDescription("L'huile depepin de  Figue de Barbarie est une huile très précieuse et très rare obtenue uniquement par pression à froid des graines d'Opuntia ficus indica.\n Sa richesse exceptionnelle en Vitamine E (environ 1000 mg/kg) et en stérols (environ 10 g/kg) lui confère une aptitude hors du commun à protéger la peau contre les radicaux libres. Elle contient par ailleurs des quantités importantes d'acides gras essentiels, dont l'acide linoléique (oméga 6), et constitue donc un excellent adoucissant et réparateur cutané. Cette huile est donc un allié exceptionnel pour lutter contre le vieillissement cutané. Propriétés cosmétiques des acides gras insaturés : nourrissantes, protectrices, adoucissantes, assouplissantes, régénérantes ,redonnent éclat et souplesse,préservent d'un vieillissement prématuré\n");
        cosmetic2.setCreatedAt(new Date());

        cosmetic2.setPayorigine("Maroc");
        cosmetic2.setImageUrl("https://www.ruche-et-flore.ch/wp-content/uploads/2021/02/HUILE-BARBARIE.jpg");
        cosmetic2.setOrganepresse("graines");
        cosmetic2.setNombotanique("Opuntiaficusindica");

        cosmetic2.setObtention("Première pression à froid");
        cosmetic2.setPrice(100);
        cosmetic2.setQuantity(2);


        //organoleptic
        Organoleptic organoleptic1 =new Organoleptic();
        organoleptic1.setAspect("liquide visqueux");
        organoleptic1.setCouleur(" jaune dorée");
        organoleptic1.setOdeur("caractéristique");
        organoleptic1.setToucher("sec");


        AcidesGras acidesGras1=new AcidesGras();
        acidesGras1.setAcidepunicique("60 à 90 %");
        acidesGras1.setAcideoleique("2 à 20 %");

        acidesGras1.setAcidealphalinolenique("≤ 1 %");
        acidesGras1.setAcideeicosenoique("≤ 2 %");
        acidesGras1.setAcidearachidique("≤ 1 %");
        acidesGras1.setAgmi("2 à 20 %");
        acidesGras1.setAgpi("60 à 90 %");
        acidesGras1.setAcidebehenique("≤ 1 %");
        acidesGras1.setAcidepalmitique("≤ 5 %");
        acidesGras1.setAcidelinoleique("≤ 1 %");

        Formule formule1=new Formule();
        formule1.setINCI("Punica Granatum Seed Oil");
        formule1.setOxydation("sensible");
        formule1.setInsaponifiable("vitamine E, polyphénols, caroténoïdes, phytostérols.");
        formule1.setSaponificationMoyenne("");
        formule1.setStabiliteTemp("sensible");
        formule1.setComedogenicite("1 (=peu comédogène)");



        cosmetic2.setOrganoleptic(organoleptic1);
        cosmetic2.setAcidesGras(acidesGras1);
        cosmetic2.setFormule(formule1);
        cosmetic2.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        int[] litrage1 = {100, 200, 300};
        cosmetic2.setLitrage(litrage1);

        cosmeticIngredientRepository.save(cosmetic2);


        CosmeticIngredient cosmetic3=new CosmeticIngredient();
        cosmetic3.setName("Huile de noyaux de pommes");
        cosmetic3.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic3.setPayorigine("Maroc");
        cosmetic3.setQuantity(50);
        int[] litrage2 = {100, 200, 300};
        cosmetic3.setLitrage(litrage2);

        cosmeticIngredientRepository.save(cosmetic3);

        // Scalp Oil/ Melange d’huile ANTI-CHUTE
        CosmeticIngredient cosmetic4 = new CosmeticIngredient();
        cosmetic4.setName("Scalp Oil/ Melange d’huile ANTI-CHUTE");
        cosmetic4.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic4.setPayorigine("Maroc");
        cosmetic4.setQuantity(50);
        int[] litrage3 = {100, 200, 300};
        cosmetic4.setLitrage(litrage3);
        cosmeticIngredientRepository.save(cosmetic4);

// Scalp Oiling For Growth & Thickness
        CosmeticIngredient cosmetic5 = new CosmeticIngredient();
        cosmetic5.setName("Scalp Oiling For Growth & Thickness");
        cosmetic5.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic5.setPayorigine("Maroc");
        cosmetic5.setQuantity(50);
        int[] litrage4 = {100, 200, 300};
        cosmetic5.setLitrage(litrage4);
        cosmeticIngredientRepository.save(cosmetic5);

// Huile Visage Régénérante Aromathérapie
        CosmeticIngredient cosmetic6 = new CosmeticIngredient();
        cosmetic6.setName("Huile Visage Régénérante Aromathérapie");
        cosmetic6.setDescription("Renouvelez, repulpez et aidez à reconstruire l'élasticité naturelle de la peau avec cette huile nourrissante. Un mélange nourrissant d'huiles de jojoba, d’argan, et de graines de figue de barbarie, pepein de raisin, ainsi que de calendula et de camomille apaisent et revitalisent la peau. aide à stimuler le renouvellement cellulaire de la peau, à lisser les ridules et à améliorer le teint et la texture de la peau pour favoriser un teint souple, lisse et éclatant.");
        cosmetic6.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic6.setPayorigine("Maroc");
        cosmetic6.setQuantity(50);
        cosmetic6.setLitrage(litrageArray);
        cosmeticIngredientRepository.save(cosmetic6);

// Nourishing Miracle Body Oil/ soin corporel nourrissant
        CosmeticIngredient cosmetic7 = new CosmeticIngredient();
        cosmetic7.setName("Nourishing Miracle Body Oil/ soin corporel nourrissant");
        cosmetic7.setDescription("Lissez votre peau  avec cette huile miracle légère et soyeuse et reconstituante. Dotée d'un mélange bienveillant d'huiles végétales riches en antioxydants et en nutriments pour nourrir en profondeur, cette huile pour le corps e Miracle aide à lisser les vergitures  et adoucir la peau et favoriser un éclat jeune et sain");
        cosmetic7.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic7.setPayorigine("Maroc");
        cosmetic7.setQuantity(50);
        cosmetic7.setLitrage(litrageArray);
        cosmeticIngredientRepository.save(cosmetic7);

// Poudre exfoliante de pépins de figues de Barbarie
        CosmeticIngredient cosmetic8 = new CosmeticIngredient();
        cosmetic8.setName("Poudre exfoliante de pépins de figues de Barbarie");
        cosmetic8.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic8.setPayorigine("Maroc");
        cosmetic8.setQuantity(50);
        cosmetic8.setLitrage(litrageArray);
        cosmeticIngredientRepository.save(cosmetic8);

// Poudre exfoliante de pépins de grenades
        CosmeticIngredient cosmetic9 = new CosmeticIngredient();
        cosmetic9.setName("Poudre exfoliante de pépins de grenades");
        cosmetic9.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic9.setPayorigine("Maroc");
        cosmetic9.setQuantity(50);
        cosmetic9.setLitrage(litrageArray);
        cosmeticIngredientRepository.save(cosmetic9);

// Poudre exfoliante de noyaux de dattes
        CosmeticIngredient cosmetic10 = new CosmeticIngredient();
        cosmetic10.setName("Poudre exfoliante de noyaux de dattes");
        cosmetic10.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic10.setPayorigine("Maroc");
        cosmetic10.setQuantity(50);
        cosmetic10.setLitrage(litrageArray);
        cosmeticIngredientRepository.save(cosmetic10);

// Poudre de betteraves biologiques
        CosmeticIngredient cosmetic11 = new CosmeticIngredient();
        cosmetic11.setName("Poudre de betteraves biologiques");
        cosmetic11.setDescription("Cuisinez en rose avec la poudre de betterave biologique.  Superaliment cru avec un gout sucré, robuste et succulent, notre poudre de betterave bio s'intègre facilement à l'alimentation quotidienne et se prête aussi bien aux recettes sales que sucrées.  Ajoutez-la à vos smoothies, riz, sauces, yogourts, vinaigrettes, soupes, pâtisseries, etc., et prenez plaisir à ajouter de la saveur, de la couleur et de la santé dans votre assiette!  100% betteraves crues et biologiques.");
        cosmetic11.setImageUrl("https://images.pexels.com/photos/5462207/pexels-photo-5462207.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2");
        cosmetic11.setPayorigine("Maroc");
        cosmetic11.setQuantity(50);
        cosmetic11.setLitrage(litrageArray);

        cosmeticIngredientRepository.save(cosmetic11);



    }
}

