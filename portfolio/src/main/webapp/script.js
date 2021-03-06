// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

/**
 * Adds a random greeting to the page.
 */
function addRandomGreeting() {
  const greetings =
      ['I am and always will be the optimist. The hoper of far-flung hopes and the dreamer of improbable dreams.', 'There is only one Lord of the Ring, only one who can bend it to his will. And he does not share power.', 'Life\'s true gift is the capacity to enjoy enjoyment.', 'Eldest, that\'s what I am... Tom remembers the first raindrop and the first acorn... He knew the dark under the stars when it was fearless - before the Dark Lord came from Outside.'];

  // Pick a random greeting.
  const greeting = greetings[Math.floor(Math.random() * greetings.length)];

  // Add it to the page.
  const greetingContainer = document.getElementById('greeting-container');
  greetingContainer.innerText = greeting;
}


function getDataServer()  {
    fetch('/data').then(response => response.json()).then((quote) => {

    const statsListElement = document.getElementById('data-container');
    statsListElement.innerHTML = '';
    var i = 0;
    while (quote.name[i] != null)  {
        statsListElement.appendChild(
            createListElement('Name: ' + quote.name[i]));
        statsListElement.appendChild(
            createListElement('Location: ' + quote.location[i]));
        statsListElement.appendChild(
            createListElement('Comment: ' + quote.comment[i]));
        statsListElement.appendChild(createListElement(" "));
        i ++;
    }
  });
}

function createListElement(text) {
  const liElement = document.createElement('li');
  liElement.innerText = text;
  return liElement;
}    
