const songs = [
  {
    title: "Ecstacy",
    artist: "Suicidal-Idol",
    file: "songs/song1.mp3",
    album: "images/song1.jpg",
  },
  {
    title: "Somebody to you",
    artist: "Vamps",
    file: "songs/song2.mp3",
    album: "images/song2.jpg",
  },
  {
    title: "Mockingbird ",
    artist: "Eminem",
    file: "songs/song3.mp3",
    album: "images/song3.jpg",
  },
  {
    title: "If we had each other",
    artist: "Alec Benjamin",
    file: "songs/song4.mp3",
    album: "images/song4.jpg",
  },
  {
    title: "Carry you home",
    artist: "Alex Warren",
    file: "songs/song5.mp3",
    album: "images/song5.jpg",
  },
  {
    title: "Perfect",
    artist: "Ed Sheeran",
    file: "songs/song6.mp3",
    album: "images/song6.jpg",
  },
  {
    title: "7 years",
    artist: "Lukas Graham",
    file: "songs/song7.mp3",
    album: "images/song7.jpg",
  },
  {
    title: "Death bed",
    artist: "Powfu",
    file: "songs/song8.mp3",
    album: "images/song8.jpg",
  },
];

let currentIndex = 0;
let isShuffle = false;
let isRepeat = false;

const audio = document.getElementById("audio");
const title = document.getElementById("song-title");
const artist = document.getElementById("song-artist");
const albumArt = document.getElementById("album-art");
const seek = document.getElementById("seek");
const playPauseBtn = document.getElementById("playPauseBtn");

let favorites = JSON.parse(localStorage.getItem("favorites") || "[]");
let recentlyPlayed = JSON.parse(localStorage.getItem("recentlyPlayed") || "[]");

function loadSong(index) {
  const song = songs[index];
  audio.src = song.file;
  title.textContent = song.title;
  artist.textContent = song.artist;
  albumArt.src = song.album || "images/default.jpg";

  updateRecentlyPlayed(song);
  renderFavorites();
  renderRecentlyPlayed();
  renderPlaylist();
  playPauseBtn.textContent = "▶️";
}

function togglePlay() {
  if (audio.paused) {
    audio.play();
    playPauseBtn.textContent = "⏸";
  } else {
    audio.pause();
    playPauseBtn.textContent = "▶️";
  }
}

function nextSong() {
  if (isShuffle) {
    let rand;
    do {
      rand = Math.floor(Math.random() * songs.length);
    } while (rand === currentIndex);
    currentIndex = rand;
  } else {
    currentIndex = (currentIndex + 1) % songs.length;
  }

  loadSong(currentIndex);

  audio.play().then(() => {
    playPauseBtn.textContent = "⏸";
  }).catch(() => {
    playPauseBtn.textContent = "▶️";
  });
}


function prevSong() {
  currentIndex = (currentIndex - 1 + songs.length) % songs.length;
  loadSong(currentIndex);
  audio.play();
}

function toggleShuffle() {
  isShuffle = !isShuffle;
  alert("Shuffle: " + (isShuffle ? "ON" : "OFF"));
}

function toggleRepeat() {
  isRepeat = !isRepeat;
  alert("Repeat: " + (isRepeat ? "ON" : "OFF"));
}

function seekSong() {
  audio.currentTime = (seek.value / 100) * audio.duration;
}

function setVolume(val) {
  audio.volume = val;
}

audio.ontimeupdate = () => {
  if (!isNaN(audio.duration)) {
    seek.value = (audio.currentTime / audio.duration) * 100;
  }
};

audio.onended = () => {
  playPauseBtn.textContent = "⏸";
  if (isRepeat) {
    audio.currentTime = 0;
    audio.play();
    playPauseBtn.textContent = "▶️";
  } else {
    nextSong();
  }
};

function isFavorite(song) {
  return favorites.some(s => s.title === song.title);
}

function toggleFavorite(song) {
  const index = favorites.findIndex(s => s.title === song.title);
  if (index === -1) {
    favorites.push(song);
  } else {
    favorites.splice(index, 1);
  }
  localStorage.setItem("favorites", JSON.stringify(favorites));
  renderFavorites();
  renderPlaylist();
}

function renderPlaylist() {
  const playlist = document.getElementById("playlist");
  playlist.innerHTML = "";
  songs.forEach((song, index) => {
    const div = document.createElement("div");
    div.innerHTML = `
      ${song.title}
      <button onclick="event.stopPropagation(); toggleFavorite(songs[${index}])">
        ${isFavorite(song) ? "❤️" : "💔"}
      </button>
    `;
    div.onclick = () => {
      currentIndex = index;
      loadSong(index);
      audio.play();
    };
    playlist.appendChild(div);
  });
}

function renderFavorites() {
  const favList = document.getElementById("favorites");
  favList.innerHTML = "";
  favorites.forEach(song => {
    const li = document.createElement("li");
    li.textContent = song.title + " ❤️";
    li.onclick = () => {
      currentIndex = songs.findIndex(s => s.title === song.title);
      loadSong(currentIndex);
      audio.play();
    };
    favList.appendChild(li);
  });
}

function updateRecentlyPlayed(song) {
  recentlyPlayed = recentlyPlayed.filter(s => s.title !== song.title);
  recentlyPlayed.unshift(song);
  if (recentlyPlayed.length > 5) recentlyPlayed.pop();
  localStorage.setItem("recentlyPlayed", JSON.stringify(recentlyPlayed));
}

function renderRecentlyPlayed() {
  const recentList = document.getElementById("recentlyPlayed");
  recentList.innerHTML = "";
  recentlyPlayed.forEach(song => {
    const li = document.createElement("li");
    li.textContent = song.title;
    li.onclick = () => {
      currentIndex = songs.findIndex(s => s.title === song.title);
      loadSong(currentIndex);
      audio.play();
    };
    recentList.appendChild(li);
  });
}

function searchSongs() {
  const query = document.getElementById("searchInput").value.toLowerCase();
  const filtered = songs.filter(s => s.title.toLowerCase().includes(query));
  const playlist = document.getElementById("playlist");
  playlist.innerHTML = "";
  filtered.forEach((song, index) => {
    const div = document.createElement("div");
    div.innerHTML = `
      ${song.title}
      <button onclick="event.stopPropagation(); toggleFavorite(songs[${index}])">
        ${isFavorite(song) ? "💔" : "❤️"}
      </button>
    `;
    div.onclick = () => {
      currentIndex = songs.findIndex(s => s.title === song.title);
      loadSong(currentIndex);
      audio.play();
    };
    playlist.appendChild(div);
  });
}

function startVoiceSearch() {
  const recognition = new webkitSpeechRecognition();
  recognition.lang = "en-US";
  recognition.start();
  recognition.onresult = event => {
    const query = event.results[0][0].transcript;
    document.getElementById("searchInput").value = query;
    searchSongs();
  };
}

// INIT
renderPlaylist();
loadSong(currentIndex);
