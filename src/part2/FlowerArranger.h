#ifndef FLOWERARRANGER_H
#define FLOWERARRANGER_H

#include <string>
#include "FlowersBouquet"

class FlowerArranger {
private:
    std::string name; 

public:
    FlowerArranger(std::string name);

    void arrangeFlowers(FlowersBouquet* bouquet);
};

#endif