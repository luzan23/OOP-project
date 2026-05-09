#ifndef DELIVERYPERSON_H
#define DELIVERYPERSON_H

#include "Person.h"
#include "FlowersBouquet.h"

class DeliveryPerson : public Person {
public:
    DeliveryPerson(std::string name);

    void deliver(Person* recipient, FlowersBouquet* bouquet);
};

#endif // !DELIVERYPERSON_H
