function findItinerary(tickets: string[][]): string[] {
  /// Setup Itinerary Map.
  const rem = new Map<string, Array<string>>();
  const DEPART = "JFK";
  for (let ticket of tickets) {
    if (!rem.has(ticket[0])) {
      rem.set(ticket[0], []);
    }
    rem.get(ticket[0])!.push(ticket[1]);
  }

  /// Sort values.
  for (let [key, values] of rem) {
    values.sort();
  }

  function travel(depart: string, itinerary: string[]): string[] {
    let destinations: string[] = rem.get(depart)!;
    if (destinations && destinations.length !== 0) {
      for (let i = 0; i < destinations.length; i++) {
        let nextDes = destinations.splice(i, 1)[0];
        let result = travel(nextDes, [...itinerary, nextDes]);
        if (result.length !== tickets.length + 1) {
          destinations.splice(i, 0, nextDes);
        } else {
          return result;
        }
      }
    }
    return itinerary;
  }

  return travel(DEPART, [DEPART]);
};

findItinerary([["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]])