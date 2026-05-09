#ifndef FLOWERARRANGER_H
#define FLOWERARRANGER_H

#include <string>
#include "FlowersBouquet.h"
#include "Person.h"

<<<<<<< HEAD
class FlowerArranger : public Person{
=======
class FlowerArranger : public Person {
    {
>>>>>>> bf264bc53fa1051023b2e49fea3dbfbbba45f072
private:
    std::string name; 

public:
    FlowerArranger(std::string name);

    void arrangeFlowers(FlowersBouquet* bouquet);
};

#endif