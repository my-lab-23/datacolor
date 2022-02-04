package models

import colorCase.{ColorPool, ColorTool}

object MyWeb {

   object MyIndex {
      var combo1 = new ColorPool()
      var combo2 = new ColorPool()
      var finalCombo = new ColorPool()

      //

      def updateCombo(): Unit = {
         this.combo1 = updateComboAux()
         this.combo2 = updateComboAux()
      }

      private def updateComboAux(): ColorPool = {
         val color1 = ColorTool.INSTANCE.genRandomColor()
         val color2 = ColorTool.INSTANCE.genRandomColor()

         val localCombo = new ColorPool()
         localCombo.addColor(color1)
         localCombo.addColor(color2)
         localCombo
      }

      //

      def sceltoUno(): Unit = {
         combo1.saveColorPool()
      }

      def sceltoDue(): Unit = {
         combo2.saveColorPool()
      }

      def runFinalCombo(): Unit = {
         val cP = ColorTool.INSTANCE.loadColorPool(9)
         finalCombo = ColorTool.INSTANCE.finalCombo(cP)
      }
   }
}
