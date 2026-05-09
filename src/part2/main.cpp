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
    Person* chris = new Person("chris");
    Person* robin = new Person("robin");
    Gardener* gardener = new Gardener("harry");
    Grower* grower = new Grower("ron" , gardener);
    Wholesaler* wholesaler = new Wholesaler("jon", grower);
    FlowerArranger* arranger = new FlowerArranger("yaara");
    DeliveryPerson* delivery = new DeliveryPerson("luzan");
    Florist* florist = new Florist("matan", wholesaler, arranger, delivery);
    std::vector<std::string> flowers = { "Roses", "Violets","Lilys", "Tulips","Sunflowers" };
    chris->orderFlowers(florist, robin, flowers);

    delete chris;
    delete robin;
    delete florist;
    delete wholesaler;
    delete grower;
    delete gardener;
    delete arranger;
    delete delivery;

    return 0;



     
}