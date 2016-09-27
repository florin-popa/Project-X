app.controller('in2', function ($scope, $http) {
    var chart;

    var i = 0;
    getInertials = function () {


        var data = {};
        // data.begin = date.begin;
        // data.end = date.end;

        $http.get("inertialsbyid").then(function (response) {


            var data = response.data;
            var series = chart.series;
            // if (i > 80) {
            //     var 0 = true;
            // }
            // else {
            //     0 = 0;
            // }

            data[i].ax;
            data[i].ay;
            data[i].az;
            data[i].gx;
            data[i].gy;
            data[i].gz;
            data[i].mx;
            data[i].my;
            data[i].mz;
            data[i].id = response.data[i].id;
            data[i].time;
            chart.series[0].addPoint([data[i].time, data[i].ax], true, 0);
            chart.series[1].addPoint([data[i].time, data[i].ay], true, 0);
            chart.series[2].addPoint([data[i].time, data[i].az], true, 0);
            chart.series[3].addPoint([data[i].time, data[i].gx], true, 0);
            chart.series[4].addPoint([data[i].time, data[i].gy], true, 0);
            chart.series[5].addPoint([data[i].time, data[i].gz], true, 0);
            chart.series[6].addPoint([data[i].time, data[i].mx], true, 0);
            chart.series[7].addPoint([data[i].time, data[i].my], true, 0);
            chart.series[8].addPoint([data[i].time, data[i].mz], true, 0);
            // chart.series[9].addPoint([data[i].time, data[i].id], true, 0);
            i += 1;


            // }

            console.log(data);
        });
    }
    setInterval(getInertials, 1000);


    var chart = new Highcharts.StockChart({
        chart: {

            // plotBackgroundImage: '../../resources/img/templ1.png',
            plotBackgroundColor: '#ECF1F6',
            plotShadow: true,
            height: 800,
            width: 1300,
            //marginleft: 50,
            renderTo: 'container6',
            type: 'spline',
            zoomType: 'x',
            events: {
                load: getInertials
            }
        },
        legend: {
            enabled: true
        },


        rangeSelector: {

            buttons: [
                {
                    type: 'hour',
                    count: 1,
                    text: '1h'
                },
                {
                    type: 'minute',
                    count: 1,
                    text: '1m'
                }, {
                    type: 'second',
                    count: 1,
                    text: '1s'
                }, {
                    type: 'milisecond',
                    count: 1,
                    text: '1ms'
                }, {
                    type: 'all',
                    text: 'All'
                }],
            selected: 3
        },


        title: {
            text: 'Inertial data',
            style: {
                color: 'red',
                fontWeight: 'bold',

            }
        },
        xAxis: {
            type: 'datetime',
            dateTimeLabelFormats: {
                milisecond: '%H:%M:%S.%L'
            },
            minRange: 5000,
            tickInterval: 5000,
            maxRange: 5000,
            useHighStocks: true,
            gridLineWidth: 1,
            title: {
                enabled: true,
                text: '<i>Loading data from server... ',
                style: {
                    fontWeight: 'normal'
                }
            }
        },
        yAxis: {
            title: {
                text: 'Value',
                //margin: 80
                gridLineWidth: 1,
            }
        },
        series: [{
            name: 'ax',
            data: [],
            dataGrouping: {
                enabled: true
            },


        }, {
            name: 'ay',
            data: [],
            dataGrouping: {
                enabled: true
            },


        }, {
            name: 'az',
            data: [],
            dataGrouping: {
                enabled: true

            },


        }, {
            name: 'gx',
            data: [],
            dataGrouping: {
                enabled: true
            },


        } ,{
            name: 'gy',
            data: [],
            dataGrouping: {
                enabled: true
            },
            pointInterval: 5000

        },{
            name: 'gz',
            data: [],
            dataGrouping: {
                enabled: true
            },


        },{
            name: 'mx',
            data: [],
            dataGrouping: {
                enabled: true
            },


        },{
            name: 'my',
            data: [],
            dataGrouping: {
                enabled: true
            },


        }, {
            name: 'mz',
            data: [],
            dataGrouping: {
                enabled: true
            },
        },



            // },{
            //     name: 'id',
            //     data: [],
            //     dataGrouping: {
            //         enabled: true
            //     },
            //
            //
            // },

        ]

    });
    $scope.operationHighChartsData = chart;

});
