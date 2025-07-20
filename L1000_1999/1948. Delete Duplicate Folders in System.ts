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
        .map((child) => `(${child.seg}${child.childrenHashCode})`)
        .join("");
      this.childrenHashCode = childrenHash;

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
    if (this.duplicate) {
      return;
    } else {
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
}

// =============================================================================================================

class Node {
  children: Map<string, Node> = new Map();
  deleted = false;
}

function deleteDuplicateFolder(paths: string[][]): string[][] {
  const root = new Node();
  // Build trie
  for (const path of paths) {
    let cur = root;
    for (const name of path) {
      if (!cur.children.has(name)) {
        cur.children.set(name, new Node());
      }
      cur = cur.children.get(name)!;
    }
  }
  // Encode subtrees
  const groups = new Map<string, Node[]>();
  encode(root, groups);
  // Mark duplicates
  for (const nodes of groups.values()) {
    if (nodes.length > 1) {
      for (const n of nodes) {
        n.deleted = true;
      }
    }
  }
  // Collect remaining paths
  const result: string[][] = [];
  collect(root, [], result);
  return result;
}

function encode(node: Node, groups: Map<string, Node[]>): string {
  if (node.children.size === 0) {
    return "()";
  }
  const parts: string[] = [];
  for (const [name, child] of node.children) {
    parts.push(name + encode(child, groups));
  }
  parts.sort();
  const sign = `(${parts.join("")})`;
  if (!groups.has(sign)) groups.set(sign, []);
  groups.get(sign)!.push(node);
  return sign;
}

function collect(node: Node, path: string[], res: string[][]) {
  for (const [name, child] of node.children) {
    if (child.deleted) continue;
    const newPath = [...path, name];
    res.push(newPath);
    collect(child, newPath, res);
  }
}
