function deleteDuplicateFolder(paths: string[][]): string[][] {
  const rootNode: FolderNode = new FolderNode("", [], true);
  const map = new Map<string, number>();

  for (const path of paths) {
    rootNode.checkAddFolder(path);
  }

  rootNode.sort();
  rootNode.hashAndMark(map);
  rootNode.checkDuplicate(map);

  const result: string[][] = [];
  rootNode.travelAndSetPath([], result);

  return result;
}

const encoder = new TextEncoder();

class FolderNode {
  constructor(seg: string, children: FolderNode[], isRoot?: boolean) {
    this.seg = seg;
    this.children = children;
    this.isRoot = isRoot ?? false;
  }

  isRoot: boolean = false;
  seg: string;
  children: FolderNode[];
  childrenHashCode: string = "";
  duplicate: boolean = false;

  checkAddFolder(paths: string[]) {
    if (!paths.length) return;
    const node = this.children.find((node) => node.seg === paths[0]);
    if (node != null) {
      paths.shift();
      node.checkAddFolder(paths);
    } else {
      const newNode = new FolderNode(paths.shift(), []);
      this.children.push(newNode);
      newNode.checkAddFolder(paths);
    }
  }

  sort() {
    this.children.sort((a, b) => a.seg.localeCompare(b.seg));
    for (const node of this.children) node.sort();
  }

  hashAndMark(map: Map<string, number>) {
    if (!this.children.length) {
      this.childrenHashCode = this.seg;
    } else {
      this.children.forEach((child) => child.hashAndMark(map));
      const childrenHash = this.children
        .map((child) => `${child.seg}${child.childrenHashCode}`)
        .join("");
      this.childrenHashCode = encoder.encode(childrenHash).toString();

      map.set(this.childrenHashCode, (map.get(this.childrenHashCode) ?? 0) + 1);
    }
  }

  checkDuplicate(map: Map<string, number>) {
    this.children.forEach((child) => child.checkDuplicate(map));
    if (map.get(this.childrenHashCode) > 1) {
      this.duplicate = true;
    }
  }

  travelAndSetPath(paths: string[], output: string[][]) {
    if (this.duplicate) return;
    if (this.isRoot) {
      this.children.forEach((child) => {
        child.travelAndSetPath([], output);
      });
    } else {
      const newPath = [...paths, this.seg];
      output.push(newPath);
      this.children.forEach((child) =>
        child.travelAndSetPath([...newPath], output)
      );
    }
  }
}
