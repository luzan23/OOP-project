#ifndef DELIVERYPERSON_H
#define DELIVERYPERSON_H

#include "Person"
#include "FlowersBouquet"

class DeliveryPerson {
private:
    std::string name; 

public:
    DeliveryPerson(std::string name);

    void deliver(Person* recipient, FlowersBouquet* bouquet);

#endif // !DELIVERYPERSON_H
