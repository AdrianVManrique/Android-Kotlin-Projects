package com.example.hw2_adrian_francis

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.androidplot.xy.*
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
 * Use the [LineFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LineFragment : Fragment() {
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

        val x: View = inflater.inflate(R.layout.fragment_line, container, false)
        plot = x.findViewById(R.id.lineFragment_plot)

        val domainLabels = arrayOf<Number>(1,2,3,4);
        val series1Number = arrayOf<Number>(4.3,2.5,3.5,4.5);
        val series2Number = arrayOf<Number>(2.4,4.4,1.8,2.8);
        val series3Number = arrayOf<Number>(2,2,3,5);

        val series1 : XYSeries = SimpleXYSeries(
            Arrays.asList(* series1Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY
            ,"A");
        val series2 : XYSeries = SimpleXYSeries(
            Arrays.asList(* series2Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY
            ,"B");
        val series3 : XYSeries = SimpleXYSeries(
            Arrays.asList(* series3Number), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY
            ,"C");

        val series1Format = LineAndPointFormatter(Color.BLUE, Color.BLUE,null,null)
        val series2Format = LineAndPointFormatter(Color.GREEN, Color.GREEN,null,null)
        val series3Format = LineAndPointFormatter(Color.MAGENTA, Color.MAGENTA,null,null)

        series1Format.setInterpolationParams(
            CatmullRomInterpolator.Params(10,
            CatmullRomInterpolator.Type.Centripetal))
        series2Format.setInterpolationParams(
            CatmullRomInterpolator.Params(10,
            CatmullRomInterpolator.Type.Centripetal))
        series3Format.setInterpolationParams(
            CatmullRomInterpolator.Params(10,
            CatmullRomInterpolator.Type.Centripetal))

        plot?.addSeries(series1,series1Format)
        plot?.addSeries(series2,series2Format)
        plot?.addSeries(series3,series3Format)

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
         * @return A new instance of fragment LineFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LineFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}