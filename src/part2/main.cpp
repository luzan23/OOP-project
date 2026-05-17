#pragma once 

#include <iostream>
#include <vector>
#include <string>

#include "Person.h"
#include "Florist.h"
#include "Wholesaler.h"
#include "Grower.h"
#include "Gardener.h"
#include "FlowerArranger.h"
#include "DeliveryPerson.h"

int main() {
    Person* Hagrid = new Person("Hagrid");
    Person* Dumbledore = new Person("Dumbledore");
    Gardener* gardener = new Gardener("Harry");
    Grower* grower = new Grower("Ron" , gardener);
    Wholesaler* wholesaler = new Wholesaler("Luzan", grower);
    FlowerArranger* arranger = new FlowerArranger("Yaara");
    DeliveryPerson* delivery = new DeliveryPerson("Draco");
    Florist* florist = new Florist("Hermione", wholesaler, arranger, delivery);
    std::vector<std::string> flowers = { "Roses", "Violets","Lilys", "Tulips","Sunflowers" };
    Hagrid->orderFlowers(florist, Dumbledore, flowers);

    delete Hagrid;
    delete Dumbledore;
    delete florist;
    delete wholesaler;
    delete grower;
    delete gardener;
    delete arranger;
    delete delivery;

    return 0;



     
}