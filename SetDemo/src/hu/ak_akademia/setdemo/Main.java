package hu.ak_akademia.setdemo;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Set<String> hashSetHalmaz = new HashSet<>();
		for (int i = 0; i < args.length; i++) {
			if (hashSetHalmaz.contains(args[i])) {
				System.out.println("A " + args[i] + " szó már szerepel a halmazban.");
			} else {
				hashSetHalmaz.add(args[i]);
			}
		}
		System.out.println(hashSetHalmaz);

		Set<String> treeSetHalmaz = new TreeSet<>();

		for (int i = 0; i < args.length; i++) {
			if (treeSetHalmaz.contains(args[i])) {
				System.out.println("A " + args[i] + " szó már szerepel a halmazban.");
			} else {
				treeSetHalmaz.add(args[i]);
			}
		}
		System.out.println(treeSetHalmaz);

		Set<String> linkedHashSetHalmaz = new LinkedHashSet<>();
		for (int i = 0; i < args.length; i++) {
			if (linkedHashSetHalmaz.contains(args[i])) {
				System.out.println("A " + args[i] + " szó már szerepel a halmazban.");
			} else {
				linkedHashSetHalmaz.add(args[i]);
			}
		}
		System.out.println(linkedHashSetHalmaz);
	}

}
