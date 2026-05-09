#include "Gardener.h"      
#include "FlowersBouquet.h" 
#include <iostream>        
#include <vector>          
#include <string>

FlowersBouquet::FlowersBouquet(std::vector<std::string> bouquet)
    : bouquet(bouquet), is_arranged(false) {
}
void FlowersBouquet::arrange() {
    is_arranged = true;
}