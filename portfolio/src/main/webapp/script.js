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

// function addBackground()  {
//     const info = document.getElementById('info-container');
//     info.innerText = "Hello, my name is Ethan Rigby and I am  a 4th year student at the University of Calgary.\n
//     I don't have many pictures on my laptop but feel free to take a look at my instagram as I like taking pictures of \n
//     flowers and the places I have been. I usually like to take macro pictures of small things like bugs and flowers. \n
//     I also love to spend time with my family when I am home since I go to school halfway across the country (around a 40 hour \n
//     car ride to be exact). I also love to snowboard and do a lot of teaching in my spare time. I go out to the mountains often\n
//     and volunteer with a group called the Canadian Adaptive Snowsports (CADS). This lets me help teach other people who have\n
//     disabilities how to snowboard. I have been working with someone for the past three years and we finally got him on and off\n
//     the chair lift successfully this year! I also coach someone who is visually impared and is striving to go to the paralympics!";
// }
