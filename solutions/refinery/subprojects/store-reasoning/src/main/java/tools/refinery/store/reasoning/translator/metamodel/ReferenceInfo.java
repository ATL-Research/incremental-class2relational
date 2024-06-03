/*
 * SPDX-FileCopyrightText: 2023 The Refinery Authors <https://refinery.tools/>
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package tools.refinery.store.reasoning.translator.metamodel;

import tools.refinery.store.reasoning.representation.PartialRelation;
import tools.refinery.store.reasoning.translator.multiplicity.Multiplicity;

public record ReferenceInfo(boolean containment, PartialRelation sourceType, Multiplicity multiplicity,
							PartialRelation targetType, PartialRelation opposite) {
}
