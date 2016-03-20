# eq-citygen
A random city generator, with pony names.

This project was made purely out of boredom. Not sure if I'll be continuing it. :P

## Build environment
Eclipse Mars.2 (4.5.2) with JRE 8.

## Sample output (truncated):
```
{
1:
Name: Maneville
Population: 18
Type: village

2:
Name: Evershade Forest
Population: 0
Type: forest

[...]

9:
Name: Canterlot
Population: 121
Type: royal

10:
Name: Fillylot
Population: 141
Type: royal
}
```

## Entering advanced mode
Entering "Advanced Mode" in EQCityGen lists the population type and all of the ponies in the city.

To enter Advanced Mode, go to `Equestria.java` and find the line that looks like:
```
city.setAdvancedMode(false);
```
Change the `false` to `true`, and then run.
