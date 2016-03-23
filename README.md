# eq-citygen
A random city generator, with pony names.

This project was made purely out of boredom. Not sure if I'll be continuing it. :P

## Build environment
Eclipse Mars.2 (4.5.2) with JRE 8.

## Sample output (truncated):
```
Equestria: {
 1 (Wooden Forest): {
  Population: 5
  Type: forest
 }
 2 (Evershade Forest): {
  Population: 0
  Type: forest
 }
 
[...]

 10 (Newville): {
  Population: 22
  Type: village
}
```

## Entering advanced mode
Entering "Advanced Mode" in EQCityGen lists the population type and all of the ponies in the city.

To enter Advanced Mode, go to `Equestria.java` and find the line that looks like:
```
public final static boolean ADVANCED_MODE = false;
```
Change the `false` to `true`, and then run.
