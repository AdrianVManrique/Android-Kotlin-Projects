package com.example.hw2_adrian_francis

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.androidplot.xy.*
import com.androidplot.xy.SimpleXYSeries
import com.androidplot.xy.XYSeries
import java.text.FieldPosition
import java.text.Format
import java.text.ParsePosition
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BarFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var plot : XYPlot? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val x: View = inflater.inflate(R.layout.fragment_bar, container, false)
        plot = x.findViewById(R.id.barFragment_plot)

        plot?.clear()

        val domainLabels = arrayOf<Number>(1,2,3,4)
        val series1Number = arrayOf<Number>(4.3F,2.5F,3.5F,4.5F)
        val series2Number = arrayOf<Number>(2.4F,4.4F,1.8F,2.8F)
        val series3Number = arrayOf<Number>(2,2,3,5)

        val series1 : XYSeries = SimpleXYSeries(Arrays.asList(* series1Number),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY
            ,"A")
        val series2 : XYSeries = SimpleXYSeries(Arrays.asList(* series2Number),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY
            ,"B")
        val series3 : XYSeries = SimpleXYSeries(Arrays.asList(* series3Number),SimpleXYSeries.ArrayFormat.Y_VALS_ONLY
            ,"C")


        val series1Format = BarFormatter(Color.BLUE,Color.BLACK)
        val series2Format = BarFormatter(Color.GREEN,Color.BLACK)
        val series3Format = BarFormatter(Color.MAGENTA,Color.BLACK)

        plot?.addSeries(series1,series1Format)
        plot?.addSeries(series2,series2Format)
        plot?.addSeries(series3,series3Format)

        val bRenderer = plot!!.getRenderer(BarRenderer::class.java)
        bRenderer?.barOrientation = BarRenderer.BarOrientation.SIDE_BY_SIDE
        bRenderer?.setBarGroupWidth(BarRenderer.BarGroupWidthMode.FIXED_GAP, 0.5f)
        plot!!.redraw()

        plot?.graph?.getLineLabelStyle(XYGraphWidget.Edge.BOTTOM)?.format = object : Format() {
            override fun format(
                obj: Any?,
                toAppendTo: StringBuffer,
                pos: FieldPosition
            ): StringBuffer {
                val i = Math.round((obj as Number).toFloat())
                return toAppendTo.append(domainLabels[i])
            }

            override fun parseObject(source: String?, pos: ParsePosition): Any? {
                return null
            }

        }

        return x
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BarFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BarFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    fun populateGraph(){

    }
}