package org.learning.dsa.stack;

import java.util.Stack;

public class SimplifyPath71 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));
    }


    public static String simplifyPath(String path) {
        // Stack to hold the valid directory names
        Stack<String> stack = new Stack<>();

        // Split the path by '/' and process each component
        String[] components = path.split("/");

        for (String component : components) {
            // If the component is empty or ".", we skip it
            if (component.equals("") || component.equals(".")) {
                continue;
            }
            // If the component is "..", pop the stack (go up one directory), if possible
            if (component.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Otherwise, it's a valid directory name, so push it onto the stack
                stack.push(component);
            }
        }

        // Construct the canonical path from the stack
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // If the stack is empty, the canonical path is just "/"
        return simplifiedPath.length() > 0 ? simplifiedPath.toString() : "/";
    }
}
