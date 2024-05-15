package com.example.motivation.data

import com.example.motivation.infra.MotivationConstants

data class Phrase(val description: String, val category: Int)

class Mock {
    private val SUN = MotivationConstants.FILTER.SUN
    private val EMOJI = MotivationConstants.FILTER.EMOJI
    private val ALL = MotivationConstants.FILTER.ALL

    val mListPhrase = listOf<Phrase>(
        Phrase("Não sabendo que era impossível, foi lá e fez.", EMOJI),
        Phrase("Você não é derrotado quando perde, você é derrotado quando desiste!", EMOJI),
        Phrase("Quando está mais escuro, vemos mais estrelas!", EMOJI),
        Phrase("Insanidade é fazer sempre a mesma coisa e esperar um resultado diferente.", EMOJI),
        Phrase("Não pare quando estiver cansado, pare quando tiver terminado.", EMOJI),
        Phrase("O que você pode fazer agora que tem o maior impacto sobre o seu sucesso?", EMOJI),
        Phrase("A melhor maneira de prever o futuro é inventá-lo.", SUN),
        Phrase("Você perde todas as chances que você não aproveita.", SUN),
        Phrase("Fracasso é o condimento que dá sabor ao sucesso.", SUN),
        Phrase(" Enquanto não estivermos comprometidos, haverá hesitação!", SUN),
        Phrase("Se você não sabe onde quer ir, qualquer caminho serve.", SUN),
        Phrase("Se você acredita, faz toda a diferença.", SUN),
        Phrase("Riscos devem ser corridos, porque o maior perigo é não arriscar nada!", SUN)
    )

    fun getPhrase(categoryId: Int): String {
        val phrase: List<Phrase> = mListPhrase

        return when (categoryId) {
            MotivationConstants.FILTER.SUN -> {
                phrase.filter { it.category == MotivationConstants.FILTER.SUN }.random()
                    .description
            }

            MotivationConstants.FILTER.EMOJI -> {
                phrase.filter { it.category == MotivationConstants.FILTER.EMOJI }.random()
                    .description
            }

            else -> {
                phrase.random()
                    .description
            }
        }
    }
}