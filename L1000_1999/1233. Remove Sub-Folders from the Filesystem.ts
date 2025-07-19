function removeSubfolders(folder: string[]): string[] {
  let n = folder.length;
  for (let i = 0; i < n; i++) {
    const currentFolder = folder[i];
    for (let j = i + 1; j < n; j++) {
      const checkingFolder = folder[j];

      if (currentFolder.length < checkingFolder.length) {
        if (checkingFolder.startsWith(currentFolder)) {
          if (
            checkingFolder.length === currentFolder.length ||
            checkingFolder[currentFolder.length] === "/"
          ) {
            folder.splice(j, 1);
            n--;
            j--;
          }
        }
      } else {
        if (currentFolder.startsWith(checkingFolder)) {
          if (
            checkingFolder.length === currentFolder.length ||
            currentFolder[checkingFolder.length] === "/"
          ) {
            folder.splice(i, 1);
            n--;
            i--;
            break;
          }
        }
      }
    }
  }

  return folder;
}
