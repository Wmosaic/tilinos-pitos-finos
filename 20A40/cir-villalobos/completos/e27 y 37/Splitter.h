#ifndef SPLITTER
#define SPLITTER

#include <iostream> 
#include <sstream> 
#include <vector> 
struct Splitter{
    static auto Split(std::string inputString, char delimiter){
        std::vector<std::string> words;
        std::stringstream ss {static_cast<std::stringstream>(inputString)};
        std::string buf;

        while (getline(ss, buf, delimiter))
            words.push_back(buf);
    
        return words;
    }
};

#endif
