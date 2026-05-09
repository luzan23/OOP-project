#pragma once 

#include <string>
#include "FlowersBouquet.h"
#include "Person.h"


class FlowerArranger : public Person {
    private:
        std::string name;

    public:
        FlowerArranger(std::string name);

        void arrangeFlowers(FlowersBouquet * bouquet);
    };


