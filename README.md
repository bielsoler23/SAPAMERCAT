# SAPAMERCAT - Pràctica Collections i Excepcions

## Descripció

Aquest projecte simula un carro de la compra d’un supermercat (SAPAMERCAT).  
Permet afegir productes de diferents tipus, mostrar el carro i generar un tiquet de compra.

## Estructura

- Producte (classe abstracta)
- Alimentacio
- Textil
- Electronica
- Compra (gestió principal)
- Main (execució)

## Decisions preses

- S’utilitza un **Map<Producte, Integer>** per guardar el carro
- Es fa servir `containsKey()` per controlar productes repetits
- Els recorreguts es fan amb:
  - forEach
  - streams + lambda

## Característiques

- Càlcul de preu dinàmic:
  - Alimentació → segons caducitat
  - Electrònica → segons garantia
- Els productes iguals es sumen al carro
- Els tèxtils:
  - No poden repetir codi de barres
  - Es mostren ordenats per composició

## Comparable i Comparator

- `Textil implements Comparable`
- També té un `Comparator` per ordenar per composició

## Funcions destacades

- `afegirAlCarro()` → gestió amb Map
- `passarCaixa()` → genera tiquet
- `mostrarCarro()` → mostra contingut

## Streams

S’utilitzen per:
- Filtrar productes
- Ordenar tèxtils
- Buscar codis

## Conclusions

El projecte utilitza correctament:
- Collections (Map, List)
- Lambda expressions
- Herència
- Polimorfisme
